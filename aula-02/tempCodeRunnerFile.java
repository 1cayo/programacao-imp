System.out.println("======BANCA DE VOTACAO======");
        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();


        if (idade < 16) {
            System.out.println("VOTO N PERMITIDO");
        } else if (idade >= 70) {
            System.out.println("VOTO FACULTATIVO");
        } else if (idade >= 18) {
            System.out.println("VOTO OBRIGATORIO");
        } else {
            System.out.println("IDADE MINIMA P/ FACULTATIVO");
        }