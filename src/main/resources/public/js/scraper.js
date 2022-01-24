const puppeteer = require('puppeteer-extra');
const pluginStealth = require('puppeteer-extra-plugin-stealth');
puppeteer.use(pluginStealth());

async function scrapeProduct(url){
    const browser = await puppeteer.launch({headless: false});
    const page = await browser.newPage();

    await page.goto(url);

    //Waits for XPath to Load
    // await page.waitForXPath('/html/body/div[3]/div[4]/div/div[2]/div[2]/div[1]/article/section[1]/p');
    const [el] = await page.$x('/html/body/div[3]/div[4]/div/div[2]/div[2]/div[1]/article/section[1]/p');
    console.log(el);
    const text = await el.getProperty('textContent');
    const rawTxt = await text.jsonValue();
    console.log({rawTxt});

    await browser.close();
}

scrapeProduct("https://www.alltrails.com/trail/us/texas/main-loop-to-restoration-way-trail").then(r => console.log(r));

