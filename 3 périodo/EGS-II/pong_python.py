import pygame
import random
import os

# Inicializar o pygame
pygame.init()

# Definir cores
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)

# Definir o tamanho da tela
WIDTH = 800
HEIGHT = 600
FPS = 60

# Definir as configurações das barras e bola
PADDLE_WIDTH = 15
PADDLE_HEIGHT = 100
BALL_SIZE = 15

# Criar a tela
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Pong Game')

# Definir fontes para a pontuação
font = pygame.font.Font(None, 36)

# Função para desenhar as barras e a bola
def draw_objects(paddle_left, paddle_right, ball):
    screen.fill(BLACK)
    pygame.draw.rect(screen, WHITE, paddle_left)
    pygame.draw.rect(screen, WHITE, paddle_right)
    pygame.draw.ellipse(screen, WHITE, ball)
    pygame.draw.rect(screen, WHITE, (WIDTH // 2 - 1, 0, 2, HEIGHT))  # linha divisória
    pygame.display.update()

# Função para mostrar a pontuação na tela
def display_score(score_left, score_right):
    score_text = font.render(f"{score_left} - {score_right}", True, WHITE)
    screen.blit(score_text, (WIDTH // 2 - score_text.get_width() // 2, 20))

# Função para salvar a pontuação
def save_score(score_left, score_right):
    with open("pontuacoes.txt", "a") as file:
        file.write(f"Jogo finalizado: {score_left} - {score_right}\n")

# Função principal do jogo
def pong_game():
    # Configurações iniciais das barras e bola
    paddle_left = pygame.Rect(50, HEIGHT // 2 - PADDLE_HEIGHT // 2, PADDLE_WIDTH, PADDLE_HEIGHT)
    paddle_right = pygame.Rect(WIDTH - 50 - PADDLE_WIDTH, HEIGHT // 2 - PADDLE_HEIGHT // 2, PADDLE_WIDTH, PADDLE_HEIGHT)
    ball = pygame.Rect(WIDTH // 2 - BALL_SIZE // 2, HEIGHT // 2 - BALL_SIZE // 2, BALL_SIZE, BALL_SIZE)
    
    ball_speed_x = random.choice((1, -1)) * 5
    ball_speed_y = random.choice((1, -1)) * 5
    paddle_left_speed = 0
    paddle_right_speed = 0
    
    score_left = 0
    score_right = 0

    clock = pygame.time.Clock()

    running = True
    while running:
        clock.tick(FPS)

        # Verificar eventos
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False

        # Controlar as barras
        keys = pygame.key.get_pressed()
        if keys[pygame.K_w] and paddle_left.top > 0:
            paddle_left.y -= 10
        if keys[pygame.K_s] and paddle_left.bottom < HEIGHT:
            paddle_left.y += 10
        if keys[pygame.K_UP] and paddle_right.top > 0:
            paddle_right.y -= 10
        if keys[pygame.K_DOWN] and paddle_right.bottom < HEIGHT:
            paddle_right.y += 10

        # Movimentar a bola
        ball.x += ball_speed_x
        ball.y += ball_speed_y

        # Colisão da bola com o topo e fundo
        if ball.top <= 0 or ball.bottom >= HEIGHT:
            ball_speed_y = -ball_speed_y

        # Colisão da bola com as barras
        if ball.colliderect(paddle_left) or ball.colliderect(paddle_right):
            ball_speed_x = -ball_speed_x

        # Pontuação (quando a bola sai da tela)
        if ball.left <= 0:
            score_right += 1
            ball = pygame.Rect(WIDTH // 2 - BALL_SIZE // 2, HEIGHT // 2 - BALL_SIZE // 2, BALL_SIZE, BALL_SIZE)
            ball_speed_x = random.choice((1, -1)) * 5
            ball_speed_y = random.choice((1, -1)) * 5
            pygame.time.delay(1000)  # Delay de 1 segundo após a pontuação

        if ball.right >= WIDTH:
            score_left += 1
            ball = pygame.Rect(WIDTH // 2 - BALL_SIZE // 2, HEIGHT // 2 - BALL_SIZE // 2, BALL_SIZE, BALL_SIZE)
            ball_speed_x = random.choice((1, -1)) * 5
            ball_speed_y = random.choice((1, -1)) * 5
            pygame.time.delay(1000)  # Delay de 1 segundo após a pontuação

        # Desenhar os objetos na tela
        draw_objects(paddle_left, paddle_right, ball)
        display_score(score_left, score_right)

        # Salvar pontuação quando terminar o jogo
        if score_left == 5 or score_right == 5:
            save_score(score_left, score_right)
            running = False

    pygame.quit()

if __name__ == "__main__":
    pong_game()
