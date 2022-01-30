document.querySelector('button').onclick = function sendIdentification() {
    const files = [...document.querySelector('input[type=file]').files];
    const promises = files.map((file) => {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onload = (event) => {
                const res = event.target.result;
                console.log(res);
                resolve(res);
            }
            reader.readAsDataURL(file)
        })
    })

    Promise.all(promises).then((base64files) => {
        console.log(base64files)

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
                console.log('Success:', data);
                document.getElementById("plant").append(
                    data.suggestions[0].plant_details.common_names[0],
                )
                document.getElementById("plantUrl").append(
                    data.images[0].url,
                )
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    })
};