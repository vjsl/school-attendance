import Estudante from "@/models/Estudante";
import Professor from "@/models/Professor";

export default interface Chamadas {
    presente: boolean;
    estudante: Estudante;
    professor: Professor;
}