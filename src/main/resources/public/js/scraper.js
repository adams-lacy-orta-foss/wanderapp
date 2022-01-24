const puppeteer = require('puppeteer');
// const pluginStealth = require('puppeteer-extra-plugin-stealth');
// puppeteer.use(pluginStealth());

async function scrapeProduct(url){
    const browser = await puppeteer.launch();
    const page = await browser.newPage();

    await page.goto(url);

    //Waits for XPath to Load
    // await page.waitForXPath('/html/body/div[3]/div[4]/div/div[2]/div[2]/div[1]/article/section[1]/p');
    const [el] = await page.$x('//*[@id="data"]/div/div[3]/div/div/div[2]/div/div[3]/pre[2]');
    console.log(el);
    const text = await el.getProperty('textContent');
    const rawTxt = await text.jsonValue();
    console.log({rawTxt});

    await browser.close();
}

scrapeProduct("https://overpass-turbo.eu/").then(r => console.log(r));

