import { useState } from "react";
import { Row, Button, Modal, Col } from "react-bootstrap";
import api from "../../services";

export default function Atividade({ atividade, get }) {
  const [show, setShow] = useState(false);
  async function increase(id) {
    try {
      await api.put(`atividade/${atividade.id}/${id}`).then(() => {
        get()
      })
    } catch {
      alert("Deu erro!");
    }
  }
  async function deletar() {
    try {
      await api.delete(`/atividade/${atividade.id}`).then(() => {
        get()
      })
    } catch {
      alert("Deu erro!");
    }
  }
  return (
    <>
      <tr>
        <td>{atividade.id}</td>
        <td>{atividade.nome}</td>
        <td>{atividade.competencia}</td>
        <td>{atividade.setor}</td>
        <td>{atividade.prazoExecucao}</td>
        <td>{atividade.status}</td>
        <td>{atividade.dataExecucao}</td>
        <td>
          <Row>
            <Button onClick={() => setShow(true)} variant="warning">
              Detalhes
            </Button>
          </Row>
        </td>
      </tr>
      <Modal show={show} onHide={() => setShow(false)}>
        <Modal.Header closeButton>
          <Modal.Title>{atividade.nome}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <h6>
            <b>Descrição:</b>
          </h6>
          <p>{atividade.descricao}</p>
          <hr />
          <h6>
            <b>Atualizar status para: </b>
          </h6>
          <Row>
            <Col md={4}>
              <Button onClick={() => increase(0)} className="btn-block" variant="warning" >Pendente</Button>
            </Col>
            <Col md={4}>
              <Button onClick={() => increase(1)} className="btn-block" variant="info" >Progresso</Button>
            </Col>
            <Col md={4}>
              <Button onClick={() => increase(2)} className="btn-block" variant="success" >Concluido</Button>
            </Col>
          </Row>
        </Modal.Body>
        <Modal.Footer>
          <Row>
            <Col md={6}>
              <Button onClick={deletar} variant="danger">
                Remover
              </Button>
            </Col>
          </Row>
        </Modal.Footer>
      </Modal>
    </>
  );
}
