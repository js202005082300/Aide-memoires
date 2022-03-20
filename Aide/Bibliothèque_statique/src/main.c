#include <point.h>
#include <screen.h>
#include <stdio.h>

/*
    New-Item main.c
    gcc -c *.c
    7za a -t7z c.7z *.c
    
    cd lib
    ar -rsc libDraw2D.a *.o

    gcc -Wall -Wextra -pedantic src/main.c -I include -L lib -lDraw2D -o prog
*/

int main(void)
{
    Screen sc = initScreen(1920, 1080);
    powerOnScreen(&sc);

    Color pixelColor = BLUE;
    Point p = createPoint(10, 10, &pixelColor);
    drawPointOnScreen(&sc, &p);

    powerOffScreen(&sc);
    return 0;
}