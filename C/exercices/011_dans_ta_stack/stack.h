#ifndef __STACK__H__ /* Eviter de faire des inclusions inutiles.*/
#define __STACK__H__

    #include <stdbool.h> //modif.

	typedef struct StackElement
	{
		Data d; //modif.
		struct StackElement *next;
	}StackElement, *Stack;


	Stack new_stack(void);
	bool is_empty_stack(Stack st); //modif (bool).
	void print_stack(Stack st);
	Stack push_stack(Stack st, Data d);
	Stack pop_stack(Stack st);
	Data top_stack(Stack st); // modif.
	int stack_length(Stack st);
	Stack clear_stack(Stack st);

#endif