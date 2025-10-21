# 📱 Kotlin Android Crypto Monitor

Aplicativo Android nativo para monitorar o preço do **Bitcoin em tempo real**, consumindo dados diretamente da **API do Mercado Bitcoin**.
O projeto foi originalmente construído com **layouts XML** e **refatorado para Jetpack Compose**, adotando práticas modernas de **UI declarativa**.

---

## 🚀 Funcionalidades Principais

* **Consulta de Cotação:** Exibe o preço atual do Bitcoin em reais.
* **Atualização em Tempo Real:** O botão “Atualizar” faz nova requisição à API.
* **Interface Declarativa (Jetpack Compose):** UI moderna e reativa.

### 💡 Melhorias Implementadas

* **Indicador de Carregamento:** Exibe animação enquanto busca os dados.
* **Tratamento de Erros:** Mostra mensagem clara quando a conexão falha.
* **Carregamento Automático:** A cotação é carregada assim que o app inicia.

---

## 🤖 Tecnologias Utilizadas

* **Kotlin** — Linguagem principal do projeto.
* **Jetpack Compose** — Toolkit moderno para UI declarativa.
* **Coroutines** — Para tarefas assíncronas (requisições de rede).
* **Retrofit** — Cliente HTTP para integração com a API.
* **ViewModel (AndroidX Lifecycle)** — Gerencia o estado da UI.

---

## 🔟 Estrutura do Projeto

```
Kotlin-Android-Crypto-Monitor/
├── app/
├── screenshots/
│   ├── loading.png
│   ├── success.png
│   └── error.png
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## 🖼️ Telas do Aplicativo

|         Estado        |                      Visual                      |
| :-------------------: | :----------------------------------------------: |
|     **Carregando**    | ![Tela de Carregamento](screenshots/loading.png) |
| **Sucesso (Cotação)** |    ![Tela de Sucesso](screenshots/success.png)   |
|  **Erro de Conexão**  |      ![Tela de Erro](screenshots/error.png)      |

---

## 📦 Como Executar o Projeto

1. **Clonar o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/android-crypto-monitor.git
   ```

2. **Abrir no Android Studio:**

   * Abrir o Android Studio > *Open an existing project* > selecionar a pasta do projeto.

3. **Sincronizar as dependências:**

   * O Android Studio deve detectar automaticamente os arquivos `build.gradle.kts` e instalar as dependências.

4. **Executar o app:**

   * Escolha um emulador ou dispositivo físico e clique em ▶️ *Run*.

---

## 👨‍💻 Integrantes do Projeto

* *Guilherme Costa* - RM98937
* *Hugo Antonio de Oliveira* - RM550153
* *Eduarda Shiratsu* - RM551188

---

> Projeto desenvolvido como parte da disciplina **Desenvolvimento Cross Platform (FIAP)**, com foco na migração de layouts XML para **Jetpack Compose**, aplicando boas práticas de UI declarativa e consumo de APIs REST.
