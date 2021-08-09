import pygame

pygame.init()
screen = pygame.display.set_mode((650, 300))
pygame.display.set_caption("Kali-T 1.0")

pygame.draw.rect(screen, (255, 128, 128), [25,500,10,5], 0)

launch = True
while launched:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            launched = False
    
    screen.fill((0, 0, 0))
    pygame.draw.line(screen, (120, 100, 225), [25, 25], [480, 260], 5)
    pygame.draw.line(screen, (120, 100, 225), [73, 200], [425, 50], 3)
    pygame.draw.line(screen, (120, 100, 225), [15, 15], [500, 15], 1)
    pygame.display.update()