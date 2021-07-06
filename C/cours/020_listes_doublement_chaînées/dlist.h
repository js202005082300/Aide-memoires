#ifndef __DLIST__H__
#define __DLIST__H__

    /* Définition d'un booléen */
    typedef enum
    {
        false,
        true
    }Bool;

    /* Définition d'un maillon de la DList */
    typedef struct DListNode
    {
        int value;
        struct DListNode *back;
        struct DListNode *next;
    }DListNode; //pas le pointeur, on veux specifier un maillon de la liste.

    /* Définition d'une DListe */
    typedef struct DList
    {
        int length;
        struct DListNode *begin; // 1er element de la liste. Permet d'avoir toute la liste.
        struct DListNode *end; // xeme element de la liste. Permet d'avoir toute la liste.
    }*DList; // pointeur vers notre boite qui definis notre liste.

    /* Prototypes */
    DList new_dlist(void);
    Bool is_empty_dlist(DList li);
    int dlist_length(DList li);
    int dlist_first(DList li);
    int dlist_last(DList li);
    void print_dlist(DList li);
    DList push_back_dlist(DList li, int x);
    DList push_front_dlist(DList li, int x);
    DList pop_back_dlist(DList li);
    DList pop_front_dlist(DList li);
    DList clear_dlist(DList li);

#endif