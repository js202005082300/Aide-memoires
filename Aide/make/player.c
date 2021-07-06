#include "player.h"
#include <stdio.h>
#include <string.h>

Player create(void)
{
    Player p;
    strcpy(p.name, "Unknown");
    p.level = 1;
    return p;
}

void say(Player p, char *message)
{
    printf("%s : %s\n", p.name, message);
}