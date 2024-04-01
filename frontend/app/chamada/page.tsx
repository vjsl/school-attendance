'use client';
import {api} from "@/utils/api";
import {useEffect, useState} from "react";
import Turma from "@/models/Turma";
import Professor from "@/models/Professor";
import Chamadas from "@/models/Chamadas";
export default function Chamada() {
    const [alunoSelecionado, setAlunoSelecionado] = useState(0);
    const [turma, setTurma] = useState({} as Turma);
    const [listaTurmas, setListTurmas] = useState({} as Turma[]);
    const [professor, setProfessor] = useState({} as Professor);
    useEffect(() => {
        api.get<Turma[]>("/turma/professor/1").then((response) => {
            setListTurmas(response.data);
            console.log(response.data)
        });
    }, []);

    function proximoAluno() {
        if (alunoSelecionado < turma.estudantes.length) {
            setAlunoSelecionado(alunoSelecionado + 1);
        }
    }

    function statusEstudante(presente: boolean) {
        const chamadas: Chamadas = {
            estudante: turma.estudantes[alunoSelecionado],
            professor: turma.professor[1],
            presente: presente
        }
        api.put("/chamada", chamadas).then(() => {
            console.log("Chamadas realizada com sucesso!");
        });


    }

    return (
        <main className="flex min-h-screen flex-col items-center justify-between p-24 bg-gray-300">
            {turma.id === undefined && listaTurmas.length > 0 &&
                <div className={'mx-auto px-8 bg-white rounded-lg pt-8'}>
                    <h1 className="text-3xl font-bold text-center text-gray-600">Olá professor!</h1>
                    <p className="text-center text-gray-600">Selecione a turma para iniciar a chamada</p>
                    <div className="flex flex-col items-center">
                        {listaTurmas.map((turma, index) => (
                            <button key={index}
                                    className={'bg-blue-500 text-white px-8 py-2 rounded-full m-4'}
                                    onClick={() => setTurma(turma)}>{turma.nome + " - SALA " + turma.sala}
                            </button>
                        ))}
                    </div>
                </div>
            }
            {turma.id !== undefined && turma.id !== null &&
                <div className={'mx-auto px-8 bg-white rounded-lg pt-8'}>
                    <h1 className="text-3xl font-bold text-center text-gray-600">Assistente de chamada</h1>
                    <p className="text-center text-gray-600">Turma: {turma.nome} - Sala: {turma.sala}</p>
                    <div className="flex flex-col items-center">
                        {alunoSelecionado < turma.estudantes.length &&
                            <div className={'flex flex-col pb-8'}>
                                <h2 className={'font-bold mt-8 text-center text-2xl text-gray-600'}>{turma.estudantes[alunoSelecionado].nome}</h2>
                                <img className={'w-96'} src={"/alunas/" + turma.estudantes[alunoSelecionado].foto}
                                     alt={"foto do estudante"}/>
                                <span className={'font-bold text-center mt-4 text-gray-600'}>Está presente?</span>
                                <div className={'flex justify-center'}>
                                    <button className={'bg-green-500 text-white px-8 py-2 rounded-full m-4'}
                                            onClick={() => {
                                                statusEstudante(true);
                                                proximoAluno();
                                            }}>Sim
                                    </button>
                                    <button className={'bg-red-500 text-white px-8 py-2 rounded-full m-4'}
                                            onClick={() => {
                                                statusEstudante(false);
                                                proximoAluno();
                                            }}>Não
                                    </button>
                                </div>
                            </div>
                        }
                        {alunoSelecionado >= turma.estudantes.length &&
                            <h2 className={"mt-16 text-2xl mb-16 text-gray-600 font-medium"}>
                                Encerramos a chamada!
                            </h2>
                        }
                    </div>
                </div>
            }
        </main>
    );
}