#! /usr/bin/env node

import inquirer from 'inquirer';
import { questionArray, createShortURL } from './inquirerUtils.js';

console.log('Welcome to the URL Shortener app!! You can exit at any time using control + c.');

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