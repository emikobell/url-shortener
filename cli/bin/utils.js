const validateURL = (URL) => {
    if (!URL.startsWith('http://') || !URL.startsWith('https://')) {
        console.log('Invalid URL. Please enter a URL that begins with "http://" or "https://".')
    }
};

module.exports = { validateURL: validateURL };