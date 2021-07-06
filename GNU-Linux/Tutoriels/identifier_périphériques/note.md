# [Identifier périphériques](https://www.youtube.com/watch?v=MCCCxmfNTJo)

## lspci
> Lister les périphérique PCI.
```bash
sam@sam-sam:~$ lspci
00:00.0 Host bridge: #etc.
00:01.0 ISA bridge: #etc.
00:01.1 IDE interface: #etc.
00:02.0 VGA compatible controller: #etc.
00:03.0 Ethernet controller: #etc.
00:04.0 System peripheral: #etc.
00:05.0 Multimedia audio controller: #etc.
00:06.0 USB controller: #etc.
00:07.0 Bridge: #etc.
00:0d.0 SATA controller: #etc.
```

+ Mode verbeux (simple/double/tripple)
```bash
sam@sam-sam:~$ lspci -v
sam@sam-sam:~$ lspci -vv
sam@sam-sam:~$ lspci -vvv
sam@sam-sam:~$ lspci -vvv > out.txt
sam@sam-sam:~$ gedit out.txt
```

+ Filtrer les périphériques PCI liées à ma partie internet.
```bash
sam@sam-sam:~$ lspci | grep Ethernet
00:03.0 Ethernet controller: Intel Corporation 82540EM Gigabit Ethernet Controller (rev 02)
```

## lsusb
> Lister les périphériques USB.
```bash
sam@sam-sam:~$ lsusb
Bus 001 Device 002: ID 80ee:0021 VirtualBox USB Tablet
Bus 001 Device 001: ID 1d6b:0001 Linux Foundation 1.1 root hub
```

+ Mode verbeux
```bash
sam@sam-sam:~$ lsusb -a
lsusb: invalid option -- 'a'
Usage: lsusb [options]...
List USB devices
  -v, --verbose
      Increase verbosity (show descriptors)
#etc
sam@sam-sam:~$ lsusb -v 
#etc
```

## dmesg
> Afficher des informations sur le noyau (Kernel)
```bash
sam@sam-sam:~$ man dmesg
sam@sam-sam:~$ dmesg
#etc.
sam@sam-sam:~$ dmesg | grep Ethernet
sam@sam-sam:~$ dmesg | grep graphic
[    6.493165] [TTM] Zone  kernel: Available graphics memory: 502164 KiB
sam@sam-sam:~$ dmesg | grep ram
#etc
sam@sam-sam:~$ dmesg | grep cpu
#etc
```