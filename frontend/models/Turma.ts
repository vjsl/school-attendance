import {TipoTurma} from "@/models/enum/TipoTurma";
import Estudante from "@/models/Estudante";
import Professor from "@/models/Professor";

export default interface Turma {
    id: number;
    nome: string;
    sala: number;
    tipo: TipoTurma;
    professor: Professor[];
    estudantes: Estudante[];
}