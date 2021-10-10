import styled from "styled-components";

export const Container = styled.main`
  background-color: white;
  height: 100vh;
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
  .header {
    margin-top: 50px;
    margin-bottom: 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    h1 {
      font-weight: bold;
      font-size: 48px;
      color: #32325D;
    }
  }
  .task-list {
    margin-top: 40px;
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-gap: 20px;
  }
  form {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
  }
`
