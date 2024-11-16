import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album = new Album();

        Artista artista1 = new Artista("John Lennon", "Rock");
        Artista artista2 = new Artista("Travis Scott", "Hip-Hop");

        Disco disco1 = new Disco("Mind Games", 1973, artista1);
        Disco disco2 = new Disco("Astro World", 2018, artista2);

        album.addDisco(disco1);
        album.addDisco(disco2);

        System.out.println("Álbum - Enzo Dutra");
        album.mostrarAlbum();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        try {
            while (continuar) {
                System.out.println("\nMenu:");
                System.out.println("1 - Cadastrar novo disco");
                System.out.println("2 - Cadastrar novo artista e associar a disco existente");
                System.out.println("3 - Mostrar álbum");
                System.out.println("4 - Remover disco");
                System.out.println("5 - Editar disco");
                System.out.println("6 - Sair");

                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarDisco(album, scanner);
                        break;
                    case 2:
                        cadastrarArtistaAssociado(album, scanner);
                        break;
                    case 3:
                        if (album.getFaixas().isEmpty()) {
                            System.out.println("Nenhum disco cadastrado.");
                        } else {
                            album.mostrarAlbum();
                        }
                        break;
                    case 4:
                        removerDisco(album, scanner);
                        break;
                    case 5:
                        editarDisco(album, scanner);
                        break;
                    case 6:
                        continuar = false;
                        System.out.println("Finalizando...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception erro) {
            System.out.println("Você fez alguma coisa errada ou deu algum erro na execução do código!");
        }
        scanner.close();
    }

    private static void cadastrarDisco(Album album, Scanner scanner) {
        System.out.print("Digite o título do disco: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o ano de lançamento: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do artista: ");
        String nomeArtista = scanner.nextLine();

        System.out.print("Digite o gênero musical do artista: ");
        String genero = scanner.nextLine();

        Artista artista = new Artista(nomeArtista, genero);
        Disco disco = new Disco(titulo, ano, artista);

        album.addDisco(disco);
        System.out.println("Disco cadastrado com sucesso!");
    }

    private static void cadastrarArtistaAssociado(Album album, Scanner scanner) {
        if (album.getFaixas().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }

        System.out.println("Discos disponíveis:");
        album.mostrarAlbum();

        System.out.print("Digite o título do disco para associar o novo artista: ");
        String tituloDisco = scanner.nextLine();

        Disco discoEncontrado = null;
        for (Disco disco : album.getFaixas()) {
            if (disco.getTitulo().equalsIgnoreCase(tituloDisco)) {
                discoEncontrado = disco;
                break;
            }
        }

        if (discoEncontrado == null) {
            System.out.println("Disco não encontrado.");
            return;
        }

        System.out.print("Digite o nome do novo artista: ");
        String nomeArtista = scanner.nextLine();

        System.out.print("Digite o gênero musical do novo artista: ");
        String genero = scanner.nextLine();

        Artista novoArtista = new Artista(nomeArtista, genero);
        discoEncontrado.setArtista(novoArtista);

        System.out.println("Novo artista associado ao disco com sucesso!");
    }

    private static void removerDisco(Album album, Scanner scanner) {
        if (album.getFaixas().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }

        System.out.println("Discos disponíveis:");
        album.mostrarAlbum();

        System.out.print("Digite o título do disco que deseja remover: ");
        String tituloDisco = scanner.nextLine();

        Disco discoEncontrado = null;
        for (Disco disco : album.getFaixas()) {
            if (disco.getTitulo().equalsIgnoreCase(tituloDisco)) {
                discoEncontrado = disco;
                break;
            }
        }

        if (discoEncontrado == null) {
            System.out.println("Disco não encontrado.");
            return;
        }

        album.removeDisco(discoEncontrado);
        System.out.println("Disco removido com sucesso!");
    }

    private static void editarDisco(Album album, Scanner scanner) {
        if (album.getFaixas().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }

        System.out.println("Discos disponíveis:");
        album.mostrarAlbum();

        System.out.print("Digite o título do disco que deseja editar: ");
        String tituloDisco = scanner.nextLine();

        Disco discoEncontrado = null;
        for (Disco disco : album.getFaixas()) {
            if (disco.getTitulo().equalsIgnoreCase(tituloDisco)) {
                discoEncontrado = disco;
                break;
            }
        }

        if (discoEncontrado == null) {
            System.out.println("Disco não encontrado.");
            return;
        }

        System.out.println("\nO que deseja editar?");
        System.out.println("1 - Nome do disco.");
        System.out.println("2 - Ano de lançamento.");
        System.out.println("3 - Nome do artista.");
        System.out.println("4 - Genero.");

        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo título: ");
                String novoTitulo = scanner.nextLine();
                discoEncontrado.setTitulo(novoTitulo);
                System.out.println("Nome do disco editado com sucesso.");
                break;
            case 2:
                System.out.println("Digite o novo ano de lançamento: ");
                int novoAnoLancamento = scanner.nextInt();
                discoEncontrado.setAnoLancamento(novoAnoLancamento);
                System.out.println("Ano de lançamento do disco editado com sucesso.");
                break;
            case 3:
                System.out.println("Digite o novo artista: ");
                String novoArtista = scanner.nextLine();
                discoEncontrado.getArtista().setNome(novoArtista);
                System.out.println("Nome do artista do disco editado com sucesso.");
                break;
            case 4:
                System.out.println("Digite o novo gênero: ");
                String novoGenero = scanner.nextLine();
                discoEncontrado.getArtista().setGeneroMusical(novoGenero);
                System.out.println("Gênero do disco editado com sucesso.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}