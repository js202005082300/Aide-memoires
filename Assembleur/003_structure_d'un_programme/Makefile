# Samuel Jacquet
# 13-01-20

#compilation dans d'autres langages.
assembling :
	nasm -f win64 main.asm -o main.obj

linking :
	golink.exe main.obj /entry main /console kernel32.dll

executing :
	main.exe
	
ALL :
	nasm -f win64 main.asm -o main.obj
	golink.exe main.obj /entry main /console kernel32.dll
	main.exe
	
clean :
	-del *.obj
	-del main.exe

zip :
	7z a -tzip prog.zip makefile *.obj *.o *.asm