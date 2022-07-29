bits 64

extern GetStdHandle
extern WriteConsoleA
extern ReadConsoleA
extern ExitProcess

STD_OUTPUT_HANDLE: equ -11
STD_INPUT_HANDLE: equ -10
SHADOWSPACE_SIZE: equ 32 + 8
NULL: equ 0

section .data
    message: db "Quel est ton nom ? "
    MESSAGE_LENGTH: equ $-message
    USERNAME_MAX_LENGTH: equ 12

section .bss
    written: resd 1
    read: resd 1
    username: resb USERNAME_MAX_LENGTH

section .text
    global main
    main:
        ;---------------------------------------------------------------------
        sub rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        ; Demande saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, message
        mov r8, MESSAGE_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA

        ; Lecture au clavier
        mov rcx, STD_INPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, username
        mov r8, USERNAME_MAX_LENGTH
        mov r9, read
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call ReadConsoleA

        ; Affichage de la saisie
        mov rcx, STD_OUTPUT_HANDLE
        call GetStdHandle

        mov rcx, rax
        mov rdx, username
        mov r8, USERNAME_MAX_LENGTH
        mov r9, written
        mov qword [rsp + SHADOWSPACE_SIZE], NULL
        call WriteConsoleA

        ;---------------------------------------------------------------------
        add rsp, SHADOWSPACE_SIZE
        ;---------------------------------------------------------------------

        xor rcx, rcx
        call ExitProcess