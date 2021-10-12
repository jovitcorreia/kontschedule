import axios from "axios";
import { useEffect, useState } from "react";
import {
  Button,
  Container,
  Tabs,
  Tab,
  Row,
  Col,
  Modal,
  Form,
} from "react-bootstrap";
import { format, addDays } from "date-fns";

import List from "../../components/Sections/List";
import api from "../../services";

export default function HomePage() {
  const [contador, setContador] = useState({});
  const [loading, setLoading] = useState(false);
  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState({
    nome: "",
    descricao: "",
    setor: "",
  });

  useEffect(() => {http://localhost:8080/
    getContador();
  }, []);

  async function adicionarNovaAtividade(atividade) {
    try {
      const hoje = Date.now();
      await api.post("/atividade", {
        ...formData,
        competencia: format(hoje, "yyyy/MM/dd"),
        prazoExecucao: format(addDays(hoje, 3), "yyyy/MM/dd"),
        idContador: contador.id,
        idEmpresa: 2,
      }).then(() => {
        getContador()
        setShowModal(false)
      })
    } catch {
      alert("Deu erro!");
    }
  }

  async function getContador() {
    setLoading(true);
    try {
      const response = await api.get("/contador/1");
      setContador(response.data);
    } catch {
      alert("Deu erro!");
    } finally {
      setLoading(false);
    }
  }

  if (loading) {
    return <h1>carregando...</h1>;
  } else {
    return (
      <>
        <Container>
          <h1>
            {contador.nome}
          </h1>
          <Button onClick={() => setShowModal(true)}>Nova Atividade</Button>
          <Tabs defaultActiveKey="list1" className="mb-3">
            <Tab eventKey="list1" title="Atividades">
              <List atividades={contador.atividades} get={getContador} />
            </Tab>
          </Tabs>
        </Container>
        <Modal show={showModal} onHide={() => setShowModal(false)}>
          <Modal.Header closeButton>
            <Modal.Title>Nova atividade</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Row>
              <Col md={4}>
                <Form.Group className="mb-3">
                  <Form.Label>Nome</Form.Label>
                  <Form.Control
                    onChange={(e) =>
                      setFormData({ ...formData, nome: e.target.value })
                    }
                    value={formData.nome}
                  />
                </Form.Group>
              </Col>
              <Col md={4}>
                <Form.Group className="mb-3">
                  <Form.Label>Setor</Form.Label>
                  <Form.Control
                    onChange={(e) =>
                      setFormData({ ...formData, setor: e.target.value })
                    }
                    value={formData.setor}
                  />
                </Form.Group>
              </Col>
              <Col md={4}>
                <Form.Group className="mb-3">
                  <Form.Label>Descrição</Form.Label>
                  <Form.Control
                    value={formData.descricao}
                    onChange={(e) =>
                      setFormData({ ...formData, descricao: e.target.value })
                    }
                    as="textarea"
                    rows={3}
                  />
                </Form.Group>
              </Col>
            </Row>
          </Modal.Body>
          <Modal.Footer>
            <Row>
              <Col md={6}>
                <Button onClick={adicionarNovaAtividade} variant="danger">
                  Adicionar
                </Button>
              </Col>
            </Row>
          </Modal.Footer>
        </Modal>
      </>
    );
  }
}
