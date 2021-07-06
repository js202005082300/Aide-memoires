bits 64

extern GetStdHandle
extern WriteConsoleA
extern ExitProcess

section .data
	message db 'Bonjour tout le monde', 10
	message_length equ $-message

section .bss
	written resq 1

section .text
	global main
	main:
		mov rcx, -11
		call GetStdHandle
		
		sub rsp, 32
		sub rsp, 8
		
		mov rcx, rax
		mov rdx, message
		mov r8, message_length
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		
		add rsp, 32+8
		
		xor ecx, ecx
		call ExitProcess