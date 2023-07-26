import { renderLoadingBar } from "./loadingUtils.js";

const validateURL = (URL) => {
    if (URL.startsWith('http://') || URL.startsWith('https://')) {
        return true;
    }
    return 'Invalid URL. Please enter a URL that begins with "http://" or "https://".';
};


const createShortURL = async (longURL) => {
    renderLoadingBar();
    const response = await fetch('http://localhost:8080/urlshortener',
        {
            'method': "POST",
            'headers': {
                "Content-Type": "application/json",
              },
            'body': JSON.stringify(
                {
                    'longURL': longURL
                }
            )
        }
    );
    renderLoadingBar(50);
    if (response.status !== 200) {
        throw new Error('A server error occurred.');
    }
    const URLobj = await response.json();
    renderLoadingBar(100);
    return URLobj.shortUrl;
};

const questionArray = [
    {
        'type': 'input',
        'name': 'URL',
        'message': 'Please enter a URL to shorten (e.g. https://www.test.com):',
        'validate': validateURL,
    },
    {
        'type': 'confirm',
        'name': 'confirm',
        'message': 'A short URL will be generated for the URL above. Would you like to proceed?',
    }
];

export { questionArray, createShortURL };