let d = new Date(2012, 04, 23, 16, 45, 17);

document.write("<p>" + d.getMonth() + "</p>");

d.setUTCMonth(5);

document.write("<p>" + d.getMonth() + "</p>");