#if !defined(__PLAYER__H__)
// fichier d'en-tête pour un player.
    #define __PLAYER__H__
    typedef struct __PLAYER__H__
    {
        char name[26];
        int level;
    }Player;
    Player create(void);
    void say(Player p, char *message);    
#endif