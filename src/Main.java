import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    /* Gostaria de deixar algumas observações: Não foi especificado qual línguagem tinha que ser feito
     e como deveria ser feito se dessa forma abaixo ou criando classes objetos para estrela, meteoros e afins.
     A forma de como foi proposto esse desafio me passou uma impressão de ter sido "entregue/jogado" de qualquer
     jeito (se essa foi a intenção OK, mas se não foi esse desafio foi entregue de uma forma sem informações)
    * */
        public static void main(String[] args) {
            try {

                BufferedImage image = ImageIO.read(new File("src/image/img.png"));

                int countStars = 0;
                int countMeteors = 0;
                int meteorsOnWater = 0;

                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        Color pixelColor = new Color(image.getRGB(i, j));

                        // Contar estrelas - branco
                        if (pixelColor.equals(Color.WHITE)) {
                            countStars++;
                        }

                        // Contar meteoros - vermelho
                        if (pixelColor.equals(Color.RED)) {
                            countMeteors++;
                            //Verifica se o meteoro está caindo perpendicularmente na água
                            if (isMeteorFallingOnWater(i, j, image)) {
                                meteorsOnWater++;
                            }
                        }
                    }
                }

                System.out.println("Número de Estrelas: " + countStars);
                System.out.println("Número de Meteoros: " + countMeteors);
                System.out.println("Meteoros caindo na Água: " + meteorsOnWater);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Função para os meteoros caindo na
        private static boolean isMeteorFallingOnWater(int x, int y, BufferedImage image) {
            // Verifica se abaixo do vermelho tem um azul
            for (int i = y; i < image.getHeight(); i++) {
                Color pixelColor = new Color(image.getRGB(x, i));
                if (pixelColor.equals(Color.BLUE)) {
                    return true;
                }
                if (pixelColor.equals(Color.BLACK)) {
                    return false;
                }
            }
            return false;
        }
    }
