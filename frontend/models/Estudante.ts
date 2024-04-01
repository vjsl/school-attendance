import Responsavel from "@/models/Responsavel";

export default interface Estudante {
    id: number;
    nome: string;
    dataNascimento: Date;
    sexo: string;
    responsavel: Responsavel[];
    qtdeFaltas: number;
    foto: string;
}