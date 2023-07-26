const renderLoadingBar = (percent = 0) => {
    const loadingBar = {
        'progress': '.'.repeat(percent/2),
        'left': ' '.repeat(50 - percent/2),
        'percent': percent
    }; 

    process.stdout.write(`\r Generating URL ${loadingBar.progress}${loadingBar.left} ${loadingBar.percent}%`);
}

export { renderLoadingBar };