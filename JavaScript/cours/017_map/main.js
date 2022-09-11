let someMap = new Map();

someMap.set(1, "Un");
someMap.set(2, "Deux");

function showMeTheTruth(value, key)
{
    document.write("<p>(" + key + ", " + value + ")</p>");
}

someMap.forEach(showMeTheTruth);