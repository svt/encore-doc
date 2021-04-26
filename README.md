# Encore Documentation

[![License: CC BY-SA 4.0](https://img.shields.io/badge/License-CC%20BY--SA%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-sa/4.0/)
[![REUSE status](https://api.reuse.software/badge/github.com/fsfe/reuse-tool)](https://api.reuse.software/info/github.com/fsfe/reuse-tool)

<img align="right" height="120" src="https://raw.githubusercontent.com/svt/encore-doc/main/src/img/encore_doc_logo.png">

This is the documentation for the [Encore](https://github.com/svt/encore) project.
It is mainly aimed at advanced technical users, like developers.

**Encore** is a scalable tool for video transcoding,

[Online documentation](https://svt.github.io/encore-doc/)

Contributions are encouraged and welcomed.

## Development

Checkout the project. Build the documentation by invoking the 'asciidoctor' goal:

```console
foo@bar:~$./gradlew clean asciidoctor
```
    

View the generated documentation in a browser of choice, for example

```console
foo@bar:~$firefox build/docs/asciidoc/index.html
```

---
**Note**

The online documentation (GitHub Pages) is updated when something is committed to master.

---

### Requirements

-   Gradle 6.x.x

-   Optional: Intellij with the Asciidoctor Plugin

### IntelliJ Plugin

Install the [Asciidoctor plugin](https://plugins.jetbrains.com/plugin/7391-asciidoc) and get writing, with a preview window, export to HTML, PDF and more. It is great actually.

## License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br /><a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Attribution-ShareAlike 4.0 International License</a>

## Credits

-   [Write The Docs](https://www.writethedocs.org/) and everyone driving the Docs-As-Code philosophy.

- [Asciidoctor skins project](https://github.com/darshandsoni/asciidoctor-skins)

- [Highlights](https://highlightjs.org/)

