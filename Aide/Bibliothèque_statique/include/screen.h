#ifndef __SCREEN__
    #define __SCREEN__

    #include "point.h"
    #include <stdbool.h>

    typedef struct Screen
    {
        int width;
        int height;
        bool isOn;
    }Screen;

    Screen initScreen(int w, int h);
    void powerOnScreen(Screen* scr);
    void powerOffScreen(Screen* scr);
    void drawPointOnScreen(Screen* scr, Point* pt);

#endif