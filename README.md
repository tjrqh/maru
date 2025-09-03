<div align="center">
  <h1>AI와 K-Content로 배우는 한국어 학습 Maru</h1>
</div>
<br />
<br/>
<div>
  <h2>프로젝트 소개</h2>
</div>
K-콘텐츠가 세계적으로 주목받는 시기에, 외국인이 한국어를 재미있고 자연스럽게 학습할 수 있도록 K-콘텐츠(K-pop, K-드라마 등)를 활용한 AI 기반 학습 서비스를 개발하였습니다.

기존 학습 서비스는 단순히 문제를 제공하는 데 그쳤지만, Maru는 콘텐츠와 AI를 결합하여 재미와 몰입도를 높이고, 개인 맞춤형 학습 경험을 제공하고자 제작하였습니다.
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
          <img width="50" src="https://github.com/user-attachments/assets/7eff9cea-78ac-429b-baf6-a55808e3b434" />
          <p align="center">
            Next.js
          </p>
        </div>
      </td>
    </tr>

  </tbody>
</table>

### 백엔드

<table>
  <tbody>
    <tr>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://miro.medium.com/v2/resize:fit:400/1*1-13QxXfUE1mdrK_MfqonQ.png" />
          <p align="center">
            Spring Security
          <p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://spring.io/img/projects/spring-data.svg" />
          <p align="center">
            JPA
          </p>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="50" src="https://spring.io/img/projects/spring-boot.svg" />
          <p align="center">
            spring boot
          </P>
        </div>
      </td>
      <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="40" src="https://github.com/yms1789/Algorithm/assets/71623879/88040938-e044-429c-8c96-81c065e70b09" />
          <p align="center">
            AWS RDS
          </p>
        </div>
      </td>
    </tr>
    <tr>
    <td align="center" valign="middle">
        <div>
          <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/1x1.png" width="500" height="1" />
          <img width="70" src="https://github.com/yms1789/Algorithm/assets/71623879/5bca294b-55e7-43d0-98bd-4b74bf28299a" />
          <p align="center">
            mysql
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
          <img width="50" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/GitHub_Invertocat_Logo.svg/640px-GitHub_Invertocat_Logo.svg.png" />
          <p align="center">
            Git
          </p>
        </div>
      </td>
    </tr>
  </tbody>
</table>

<br /><br />

## 팀원 소개

| 이름 | 강해빈                                                                                              | 김지훈                                                                                              | 여민수                                                                                              |
| :--: | :-------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------- |
|      | <img src="https://gudgement.s3.ap-northeast-2.amazonaws.com/readme/kkogkkogGames.png" width="150"/> | <img src="https://gudgement.s3.ap-northeast-2.amazonaws.com/readme/kkogkkogGames.png" width="150"/> | <img src="https://gudgement.s3.ap-northeast-2.amazonaws.com/readme/kkogkkogGames.png" width="150"/> |
| 역할 | FRONT-END                                                                                           | FRONT-END                                                                                           | FRONT-END                                                                                           |
| 담당 | ∙ 회원 관리 <br> ∙ 소비 내역 분석                                                                   | ∙ 게임 <br> ∙ 매칭 시스템                                                                           | ∙ 초기 환경 구축 <br> ∙ 커스터마이징 <br> ∙ 페이지 라우팅 <br> ∙ 푸시알림                           |

| 이름 | 강노아                                                                                              | 권민우                                                                                              | 김민석                                                                                              |
| :--: | :-------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------- |
|      | <img src="https://gudgement.s3.ap-northeast-2.amazonaws.com/readme/kkogkkogGames.png" width="150"/> | <img src="https://gudgement.s3.ap-northeast-2.amazonaws.com/readme/kkogkkogGames.png" width="150"/> | <img src="https://gudgement.s3.ap-northeast-2.amazonaws.com/readme/kkogkkogGames.png" width="150"/> |
| 역할 | INFRA, BACK-END                                                                                     |  INFRA,BACK-END                                                                                      | BACK-END                                                                                            |
| 담당 | ∙ 서버 구축 <br> ∙ 계좌 <br> ∙ 랭킹 시스템                                                          | ∙ 장소 검색 <br> ∙ 일자리 검색 <br> ∙ 유행어 사전 <br> ∙ 백엔드 서버 배포                              | ∙ 회원관리 <br> ∙ 마이페이지 <br> ∙ 음성인식 AI 챗봇                                                       |

<br />

## ERD

<img src="https://seniornaver.s3.ap-northeast-2.amazonaws.com/readme/d105_erd+(1).jpg" width="1500"/>

<br>


## 시니어 네이버, 어떻게 만들었나요?

### 1️⃣ 피그마를 사용하여 기획 및 디자인 하였습니다.

[//]: # '<img width="25" src="https://cdn.builder.io/api/v1/image/assets%2FYJIGb4i01jvw0SRdL5Bt%2Ffb77e93c28e044178e4694cc939bf4cf" />  '

### [🎨 Figma 바로가기](https://www.figma.com/file/DdKDbgZnsNI4cKQ13Nos13/%EA%BC%AD%EA%BC%AD-%EC%94%B9%EC%96%B4%EB%A8%B9%EC%96%B4%EC%9A%94?type=design&node-id=1633-557&mode=design&t=evyZDVyMl80PGeNG-0)

시니어네이버의 **디자인 시안**과 **디자인 가이드**를 확인할 수 있습니다.
피그마에 아이디어를 시각적으로 표현하고, 일관된 디자인 가이드를 적용하였습니다.
사용자에게 직관적인 인터페이스를 제공하며, 사용자의 연령대에 맞는 UI/UX를 구현하려고 노력하였습니다.

<br />

### 2️⃣ 체계적인 개발 프로세스를 거쳤어요.

### [🔎 프로젝트 개발 과정 바로가기](https://haegu.notion.site/f1ab62bafbcf49ac98a3c92cc7e67511?pvs=4)

<br />
<div align="center">
  <img src="https://github.com/yms1789/Algorithm/assets/71623879/f36450c5-483d-44ce-9068-21d9791e8b52" width="50%"/>
</div>

각각의 기능 별 **이슈**를 생성하고, 해당 이슈로 **브랜치**를 생성해 작업을 수행했습니다.
어떤 내용이 변경되었는지 명확하게 전달하기 위해 각 **커밋**에는 **상세한 메시지**를 추가하였습니다.

코드의 일관성과 품질을 보장하기 위해, **Eslint**와 **Prettier**를 적용했습니다.

**Jenkins**로 지속적인 통합 및 개발(CI / CD)을 구현해 프로젝트의 안정성을 높였습니다.

각 기능 구현을 마치면 **Gerrit**을 통해 팀원들과 함께 코드의 품질을 개선하고 다양한 관점을 얻을 수 있도록 **코드 리뷰**를 진행했습니다.

<br />

### 3️⃣ 프로젝트 컨벤션을 정해서 진행했어요.

### [📃 프로젝트 컨벤션 바로가기](https://haegu.notion.site/879ba3c1e08e4c46a15d45763a2990f0?pvs=4)

일관된 **개발 컨벤션**을 적용해, 프로젝트의 통일성을 높였습니다.
브랜치 이름과 커밋 메시지에 동일한 규칙을 적용해서 어떤 작업이 진행되었는지 **추적**하기 편하고 **이해**하기 쉽도록 하였습니다.
코드의 역할에 따라 **디렉토리**를 분리하였습니다.
재사용 가능한 **공통 컴포넌트**를 분리해 효율성을 높였습니다.

<br/>

### 4️⃣ 개발 과정을 담았습니다.

### [✍️ 개발 과정 확인하기](https://haegu.notion.site/Trouble-Shooting-f4a980e34c014378a43d799db4c40bbb?pvs=4)

시니어 네이버의 **탄생**과 **발전**을 볼 수 있어요.  
사용성을 높이기 위한 **리팩토링**과 어려움을 겪었던 **트러블 슈팅** 과정을 생생하게 담았습니다.
