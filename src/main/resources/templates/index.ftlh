<html lang=en>
    <head>
        <meta charset=utf-8>
        <meta http-equiv=X-UA-Compatible content="IE=edge">
        <meta name=viewport content="width=device-width,initial-scale=1">
        <link rel=icon href=favicon.ico>
        <link rel="stylesheet" href="/css/style.css">        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>window.jQuery || document.write(decodeURIComponent('%3Cscript src="js/jquery.min.js"%3E%3C/script%3E'))</script>
        <link rel="stylesheet" type="text/css" href="https://cdn3.devexpress.com/jslib/20.1.7/css/dx.common.css" />
        <link rel="stylesheet" type="text/css" href="https://cdn3.devexpress.com/jslib/20.1.7/css/dx.light.css" />
        <script src="https://cdn3.devexpress.com/jslib/20.1.7/js/dx.all.js"></script>
        <script src="/js/app.js"></script>
        <title>${title}</title>
    </head>
    <body>
        <noscript>
            <strong>We're sorry but lk doesn't work properly without JavaScript enabled. Please enable it to continue.</strong>
        </noscript>
        <div id = "container">
            <div id = "header">
                header
            </div>
            <div id = "main">            
                <div id = "category">
                    <#list categoryList as item>
                        <div class="category_item">
                            ${item.name}
                        </div>
                    </#list>
                </div>
                <div id = "book_list">
                    <#list bookList as book>
                        <div class="book_item">
                            <img src="/api/book/${book.id}/img">
                            <p>${book.name}</p>
                            <p>${book.id}</p>
                        </div>
                    </#list>
                </div>
            </div>
            <div id = "footer">
                footer
            </div>
        </div>    
    </body>
</html>