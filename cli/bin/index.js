#! /usr/bin/env node

import inquirer from 'inquirer';
import { questionArray, createShortURL } from './inquirerUtils.js';

console.log('\n\n\x1b[36m     ___    ___    _______      ___\x1b[0m'
    +'\n\x1b[36m    /  /   /  /   /  __   \\    /  /\x1b[0m'
    +'\n\x1b[36m   /  /   /  /   /  /__/  /   /  /\x1b[0m       ┏┓┓┏┏┓┳┓┏┳┓┏┓┳┓┏┓┳┓'
    +'\n\x1b[36m  /  /___/  /   /       _/   /  /_____\x1b[0m   ┗┓┣┫┃┃┣┫ ┃ ┣ ┃┃┣ ┣┫'
    + '\n\x1b[36m  \\________/   /__/\\____\\   /________/\x1b[0m   ┗┛┛┗┗┛┛┗ ┻ ┗┛┛┗┗┛┛┗'
    + '\n\n' + ' '.repeat(42) + 'Made by Emiko Bell'
    + '\n\nWelcome to the URL shortener!'
    + '\nYou can press ctrl + c to quit at any time.\n'
);

inquirer
    .prompt(questionArray)
    .then(async answer => {
        if (!answer.confirm) {
            console.log('Exiting app. Goodbye!');
            return;
        }
        const shortURL = await createShortURL(answer.URL);
        console.log(`\n Your shortened URL is: ${shortURL}`);
    })
    .catch((error) => {
        if (error.isTtyError) {
            console.log("This application must be run in an interactive environment.")
        } else {
            console.log("Something went wrong. Please try again.");
        }
    });