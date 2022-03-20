#ifndef __POINT__
    #define __POINT__

    #include "color.h"

    typedef struct Point
    {
        Color c;
        int x;
        int y;
    }Point;

    Point createPoint(int x, int y, Color* c);

#endif