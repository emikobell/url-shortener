#! /usr/bin/env node

console.log('Welcome to the URL Shortener app!!');
console.log('Please enter a URL to shorten: ');

const yargs = require('yargs');
const utils = require('./utils.js')

const options = yargs
    .scriptName("url-shortener")
    .argv;