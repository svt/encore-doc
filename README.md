# ⚠️ Obsolete — the SVT Encore documentation has moved

> **This repository is no longer maintained and its contents are outdated.**
>
> The SVT Encore documentation now lives at **<https://svt.github.io/encore/>**,
> built from the [`encore`](https://github.com/svt/encore) repository.
>
> Please update your bookmarks. The old site at <https://svt.github.io/encore-doc/>
> now redirects to the new documentation.

---

# SVT Encore Documentation

[![License: CC BY-SA 4.0](https://img.shields.io/badge/License-CC%20BY--SA%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-sa/4.0/)
[![REUSE status](https://api.reuse.software/badge/github.com/svt/encore-doc)](https://api.reuse.software/info/github.com/svt/encore-doc)

<img align="right" height="120" src="https://raw.githubusercontent.com/svt/encore-doc/main/src/img/encore_doc_logo.png">

Welcome to the [SVT Encore](https://github.com/svt/encore) documentation project.
It is mainly aimed at advanced technical users, like developers.

SVT **Encore** is a scalable tool for video transcoding,

**The documentation has moved** — see the [current online documentation](https://svt.github.io/encore/).
The content below is kept for historical reference only and is no longer updated.

## Development

Clone the project with git.
Build the documentation by invoking the 'asciidoctor' goal:

```console
foo@bar:~$./gradlew clean asciidoctor
```
    

View the generated documentation in a browser of choice, for example

```console
foo@bar:~$firefox build/docs/asciidoc/index.html
```

### Requirements

-   Gradle 7.x.x

-   Optional: Intellij with the Asciidoctor Plugin

### Optional for development: IntelliJ Plugin

Install the [Asciidoctor plugin](https://plugins.jetbrains.com/plugin/7391-asciidoc) and get writing, with a preview window, export to HTML, PDF and more. 
It is great actually.

## License

This documentation is 

* Copyright 2021 Sveriges Television AB

and released under

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br /><a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Attribution-ShareAlike 4.0 International License</a>

Note: The main project SVT Encore itself was initiated in 2018.

## Credits

-   [Write The Docs](https://www.writethedocs.org/) and everyone driving the Docs-As-Code philosophy, thanks.

- [Asciidoctor skins project](https://github.com/darshandsoni/asciidoctor-skins)

- [Highlights](https://highlightjs.org/)
