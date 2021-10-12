import { Table } from "react-bootstrap";
import Atividade from "../../Atividade";

export default function List({atividades}) {
  return (
    <>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Nome</th>
            <th>Competência</th>
            <th>Setor</th>
            <th>Prazo de Execução</th>
            <th>Status</th>
            <th>Data de Execução</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {atividades && atividades.map(atividade => (
            <Atividade atividade={atividade} />
          ))}
        </tbody>
      </Table>
    </>
  );
}
