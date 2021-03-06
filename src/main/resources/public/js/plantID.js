document.getElementById('scanplant').onclick = function sendIdentification() {
    const files = [...document.querySelector('input[type=file]').files];
    const promises = files.map((file) => {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onload = (event) => {
                const res = event.target.result;
                resolve(res);
            }
            reader.readAsDataURL(file)
        })
    })

    Promise.all(promises).then((base64files) => {
        const data = {
            api_key: plantIDAPI,
            images: base64files,
            // modifiers docs: https://github.com/flowerchecker/Plant-id-API/wiki/Modifiers
            modifiers: ["crops_fast", "similar_images"],
            plant_language: "en",
            // plant details docs: https://github.com/flowerchecker/Plant-id-API/wiki/Plant-details
            plant_details: ["common_names",
                "url",
                "name_authority",
                "wiki_description",
                "taxonomy",
                "synonyms"]
            //disease details docs: https://github.com/flowerchecker/Plant-id-API/wiki/Disease-details
            //disease_details: ["common_names", "url", "description"]
        };

        fetch('https://api.plant.id/v2/identify', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById("plantUrl").value=data.images[0].url
                document.getElementById("plant").append(data.suggestions[0].plant_details.common_names[0]);
                document.getElementById("plantpicture").src=data.images[0].url;
                document.getElementById("plantName").value=data.suggestions[0].plant_details.common_names[0]
                document.getElementById("plantDescription").value=data.suggestions[0].plant_details.wiki_description.value
                $("#display").removeClass("d-none");
                $("#plantcard").removeClass("d-none");
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    })
};