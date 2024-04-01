'use client';


import {useEffect, useState} from "react";
import {api} from "@/utils/api";
import Turma from "@/models/Turma";

export default function Alunos() {
    const [listaTurmas, setListTurmas] = useState({} as Turma[]);
    useEffect(() => {
        api.get<Turma[]>("/turma/professor/1").then((response) => {
            setListTurmas(response.data);
            console.log(response.data)
        });
    }, []);

    function getDataNascimento(data: Date) {
        return new Date(data).toLocaleDateString('pt-BR');
    }
    return (
        <div className={'flex min-h-screen flex-col bg-gray-300'}>
            <h1 className={'text-2xl font-bold text-gray-700'}>Listagem de alunos por turma</h1>
            <div className={'min-h-screen mt-4 bg-white rounded-md'}>
                {listaTurmas.length > 0 && listaTurmas.map((turma, index) => (
                    <div key={index} className={'flex flex-col p-4'}>
                        <h2 className={'text-xl font-bold text-gray-700'}>{turma.nome} - Sala {turma.sala}</h2>
                        <div className={'flex flex-col'}>
                            <table className={'w-full border-2'}>
                                <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Nascimento</th>
                                    <th>Responsável</th>
                                    <th>Faltas</th>
                                </tr>
                                </thead>
                                <tbody>
                                {turma.estudantes.map(({dataNascimento, nome, responsavel, qtdeFaltas}, index) => (
                                    <tr key={index}>
                                        <td className={'text-center'}>{nome}</td>
                                        <td className={'text-center'}>{getDataNascimento(dataNascimento)}</td>
                                        <td className={'text-center'}>{responsavel[0].nome}</td>
                                        <td className={'text-center'}>{qtdeFaltas}</td>
                                    </tr>
                                ))}
                                </tbody>
                            </table>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}