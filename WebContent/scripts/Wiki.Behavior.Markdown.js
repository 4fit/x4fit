!(function (a, b, c) {
    function d(b) {
        var c = "div".slick();
        (c.innerHTML = marked(b.textContent)),
        c.replaces(b),
            c
            .getElements("table")
            .addClass("table-fit table-condensed table-bordered"),
            c.getElements("pre > code[class|=lang] ").each(function (a) {
                a.getParent().addClass("prettify-nonum");
            });
        var d = a.PageName.replace(/\s/g, "+");
        c.getElements("h1,h2,h3,h4,h5,h6").each(function (a) {
                (a.id = "section-" + d + "-" + a.innerText.replace(/[^\w]+/g, "")),
                a.grab(
                    "a.hashlink".slick({
                        href: "#" + a.id,
                        text: "#",
                    })
                );
            }),
            c.getElements("a[href^=http://],a[href^=https://]").addClass("external"),
            c
            .getElements("a[class!=wikipage][class!=hashlink][class!=external]")
            .each(function (b) {
                (b.href = a.toUrl(b.href.replace(/^.+\//, "").replace(/%20/g, " "))),
                b.addClass("wikipage");
            }),
            c
            .getElements("img:not([src^=http://]):not([src^=https://])")
            .each(function (b) {
                (b.src =
                    a.BaseUrl +
                    "/attach/" +
                    b.src.replace(/^.+\/(.+\/)/, "$1").replace(/%20/g, " ")),
                b.addClass("inline");
            });
    }
    a.once(c, function () {
        "script"
        .slick({
                src: b,
                events: {
                    load: function (b) {
                        $$(c + " pre").each(d), a.update();
                    },
                },
            })
            .inject(document.head);
    });
})(Wiki, "scripts/marked.min.js", ".markdown");