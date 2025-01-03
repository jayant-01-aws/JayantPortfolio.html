const fs = require('fs');
const markdownIt = require('markdown-it');
const syntaxHighlight = require('@11ty/eleventy-plugin-syntaxhighlight');
const htmlmin = require('html-minifier');

const randomInteger = (min, max) => Math.floor(Math.random() * (max - min + 1)) + min;

module.exports = function(eleventyConfig) {
    // Copy the `img` and `css` folders to the output
    eleventyConfig.addPassthroughCopy('assets');

    eleventyConfig.addPlugin(syntaxHighlight);

    let markdownLibrary = markdownIt({
        html: true,
        linkify: true
    });
    eleventyConfig.setLibrary('md', markdownLibrary);

    // Shortcodes

    eleventyConfig.addPairedShortcode('demo', function(content) {
        return `<div class="example example--border">
            <div class="example__ribbon example__ribbon--tr">
                <span class="example__title">Demo</span>
            </div>
            <div class="example__content example__content--medium">${content}</div>
       </div>`;
    });
    eleventyConfig.addPairedShortcode('pattern', function(content, name) {
        const href = `/${name.toLowerCase().split(' ').join('-')}/`;
        return `<div class="pattern__item">
            <a class="pattern__link" href="${href}">
                <div class="pattern__cover">${content}</div>
                <div class="pattern__title">${name}</div>
            </a>
        </div>`;
    });

    // `size` can be `sm`, `md`, `lg`
    eleventyConfig.addShortcode('circle', function(size) {
        const s = size || 'sm';
        return `<div class="circle circle--${s}"></div>`;
    });
    // `direction` can be `hor` or `ver`
    eleventyConfig.addShortcode('line', function(dir) {
        const w = randomInteger(1, 4) * 20;
        return `<div class="line line--${dir} line--${w}"></div>`;
    });
    eleventyConfig.addShortcode('lines', function(dir, numLines) {
        const content = Array(numLines).fill('').map(_ => {
            const w = randomInteger(1, 4) * 20;
            return `<div class="line line--${dir} line--${w}"></div>`
        }).join('');
        return `<div class="lines">${content}</div>`;
    });

    // `direction` can be `hor` or `ver`
    eleventyConfig.addShortcode('rectangle', function(dir, size, width) {
        const direction = dir || 'hor';
        const s = size || 'sm';
        const w = width || randomInteger(2, 4) * 20;
        return `<div class="rectangle rectangle--${direction} rectangle--${s} rectangle--${w}"></div>`;
    });
    eleventyConfig.addShortcode('square', function(size) {
        const s = size || 'sm';
        return `<div class="square square--${s}"></div>`;
    });
    // `corner` can be one of `t`, `r`, `b`, `l`, `tr`, `br`, `tl`, `bl`
    eleventyConfig.addShortcode('triangle', function(corner, size) {
        const s = size || 'sm';
        return `<div class="triangle triangle--${corner} triangle--${s}"></div>`;
    });

    // Get the first `n` elements of a collection.
    eleventyConfig.addFilter("head", (array, n) => {
        if (!Array.isArray(array) || array.length === 0) {
            return [];
        }
        return (n < 0) ? array.slice(n) : array.slice(0, n);
    });

    eleventyConfig.addCollection('sortByTitle', function(collectionApi) {
        return collectionApi.getAll()
            .filter(function(item) {
                let extension = item.inputPath.split('.').pop();
                return extension === 'md';
            })
            .sort(function(a, b) {
                return a.data.title - b.data.title;
            });
    });

    eleventyConfig.addCollection('categories', function(collectionApi) {
        const categories = [];
        collectionApi.getAll()
            .filter(function(item) {
                let extension = item.inputPath.split('.').pop();
                return extension === 'md';
            })
            .forEach((item) => {
                const category = item.data.category;
                if (category && !categories.includes(category)) {
                    categories.push(category);
                }
            });
        return categories.sort();
    });

    eleventyConfig.addCollection('groupByCategories', function(collectionApi) {
        const categories = {};
        collectionApi.getAll()
            .filter(function(item) {
                let extension = item.inputPath.split('.').pop();
                return extension === 'md';
            })
            .forEach((item) => {
                const category = item.data.category;
                if (!category) {
                    return;
                }
                Array.isArray(categories[category])
                    ? categories[category].push(item)
                    : categories[category] = [item];
            });
        return categories;
    });

    eleventyConfig.addTransform('minify-html', function(content) {
        if (this.outputPath && this.outputPath.endsWith('.html')) {
            return htmlmin.minify(content, {
                useShortDoctype: true,
                removeComments: true,
                collapseWhitespace: true
            });
        }    
        return content;
    });

    return {
        // Control which files Eleventy will process
        // e.g.: *.md, *.njk, *.html, *.liquid
        templateFormats: [
            'md',
            'njk',
            'html',
            'liquid',
        ],
        // Pre-process *.md files with: (default: `liquid`)
        markdownTemplateEngine: 'njk',

        // Pre-process *.html files with: (default: `liquid`)
        htmlTemplateEngine: 'njk',

        // These are all optional (defaults are shown):
        dir: {
            input: 'contents',
            includes: '_includes',
            data: '_data',
            output: '_site'
        }
    };
};