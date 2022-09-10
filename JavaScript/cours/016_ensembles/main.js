let someSet = new Set(["bonjour", "hello", "hi"]);

function show(value)
{
    document.write("<p>" + value + "</p>");
}

someSet.forEach(show);