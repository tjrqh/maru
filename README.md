<div align="center">
  <h1>AI와 K-Content로 배우는 한국어 학습 Maru</h1>
</div>
<br />
<br/>
<div>
  <h2>프로젝트 소개</h2>
</div>
K-콘텐츠가 세계적으로 주목받는 시기에, 외국인이 한국어를 재미있고 자연스럽게 학습할 수 있도록 K-콘텐츠(K-pop, K-드라마 등)를 활용한 AI 기반 학습 서비스를 개발하였습니다.

기존 학습 서비스는 단순히 문제를 제공하여 몰입도와 흥미가 떨어지는 부분이 있다고 느꼈으며 이를 보완하여 Maru는 콘텐츠와 AI를 결합하여 재미와 몰입도를 높이고, 개인 맞춤형 학습 경험을 제공하고자 제작하였습니다.
<br />

<br /><br />

## 구현 기능 목록

### 1. 학습을 관리할 수 있는 **캘린더**와 다양한 사람들과 경쟁할 수 있는 **순위표**

<br />
<div align="center">
  <img src="https://github.com/user-attachments/assets/fefcd5c7-3832-4185-a940-c7a384b2de42" width="20%" />
</div>

- 사용자가 학습을 했는지에 대해서 캘린더로 표시하였습니다.
- 현재 내 점수와 다른 학습자들의 점수를 비교하여 순위를 나타내었습니다.
- 지금까지 학습했던것에 대하여 다시 재학습 할 수 있게하였습니다.

<br /><br />

### 2. AI가 생성한 문장을 기준으로한 한국어 문제 맞추기

<br />
<div align="center">
  <img src="https://github.com/user-attachments/assets/9d9ecb3d-4d06-4410-b9e0-e9712b39cc68" width="20%" />
</div>

- K-Content와 AI가 생성한 문장에 대해서 단어를 맞출 수 있게 하였습니다.
- 정답을 맞추면 Score를 휙득하게 하였습니다.

<br /><br />

### 3. 말하면서 배울 수 있는 **음성 정답 기능**

<br />
<div align="center">
  <img src="https://github.com/user-attachments/assets/15228570-c191-4e5d-8292-55208b21f5c4" width="20%" />
</div>

- AWS Poly와 Transcribe를 통해 음성을 만들거나 인식할 수 있습니다.

<br /><br />
## 사용한 기술

<table>
  <tbody>
    <tr>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Typescript_logo_2020.svg/640px-Typescript_logo_2020.svg.png" />
          <p align="center">
            TypeScript
          </p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://github.com/user-attachments/assets/7eff9cea-78ac-429b-baf6-a55808e3b434" />
          <p align="center">
            Next.js
          </p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://spring.io/img/projects/spring-boot.svg" />
          <p align="center">
            Spring Boot
          </p>
        </div>
      </td>
    </tr>

  </tbody>
</table>

### AWS

<table>
  <tbody>
    <tr>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://github.com/user-attachments/assets/8b8ff7d7-c521-407a-a544-6d8934efef27" />
          <p align="center">
            AWS EC2
          <p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://github.com/user-attachments/assets/81702820-a7bc-46ac-88f1-6bf38389a9df" />
          <p align="center">
            AWS Bedrock
          </p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://github.com/user-attachments/assets/1fd23910-16fc-4261-8d0b-a40374172c76" />
          <p align="center">
            AWS Lambda
          </P>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="40" src="https://github.com/user-attachments/assets/2fdc1e76-06d6-41a3-b45c-cb8382972936" />
          <p align="center">
            AWS Poly
          </p>
        </div>
      </td>
    </tr>
    <tr>
    <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="70" src="https://github.com/user-attachments/assets/cd9d454c-808d-4bae-bd32-69ca90cd0541" />
          <p align="center">
            AWS Aurora mysql
          </p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://github.com/yms1789/Algorithm/assets/71623879/ba3c8197-f868-41e5-8da9-accd3c49f3ad" />
          <p align="center">
            Amazon S3
          </p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://github.com/user-attachments/assets/d5f79428-a7d2-47ad-a3aa-dc437293847d" />
          <p align="center">
            AWS Transcribe
          </p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://github.com/user-attachments/assets/6d7e07ba-57c2-4aec-965c-e869983cb463" />
          <p align="center">
            AWS Cognito
          </p>
        </div>
      </td>
    </tr>
  </tbody>
</table>


<br /><br />

## 팀원 소개

| 이름 | 역할        | 담당                                                                 |
| :--: | :---------: | :------------------------------------------------------------------- |
|  김보석   | Back-END   | API 서버, 서버 배포                                            |
|  장보명   | INFRA / Back-END   | 로그인 환경 구축, 서버 배포, PIPE-LINE                                                    |
|  엄윤주   | FRONT-END   | 모바일 화면 구축, 음성 서비스               |
|  변승희  | INFRA / AI | AI 설정, 데이터 변환                                       |                                                                                                         |

<br />

## AWS Archetecture

<img src="https://github.com/user-attachments/assets/8980829e-be88-492e-bb3f-5321b188ebf7" width="1500"/>

<br>

## Maru PPT
https://www.canva.com/design/DAGSzcGdKlE/jnaqX0WcLSqnEduf_T4oYg/view?utm_content=DAGSzcGdKlE&utm_campaign=designshare&utm_medium=link&utm_source=editor#31
