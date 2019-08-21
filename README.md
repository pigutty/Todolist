# Today's Todolist(2019/08記述)
一日のタスクを管理するシンプルなアプリ。

# 使い方
1. 1日のタスクをSprintToDoの欄に列挙する。
2. タスクに取り掛かる際に、カードの編集ボタンを押して、DoingNowに移動する。
3. タスクが完了したら、もう一度編集ボタンを押して、Completedに移動する。
4. これを繰り返して、1日の目標を達成しましょう。

# 使用した技術要素(工事中)
- fontawesome5(CDN)
- etc...

# 開発環境のセットアップ手順(工事中)
1. [こちらのサイト](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)からJDKをインストール。
2. [こちらのサイト](https://maven.apache.org/download.cgi)からMavenをダウンロード(binaryの方)。その後~/.bash_profileで、環境変数PathをダウンロードしたMavenのbinまで通しておく。これでmvnコマンドを実行できるようにした。(gradleも同様にファイルをダウンロードして、環境変数PATHを通すところまではやりました。)
3. [Spring Initializr](https://start.spring.io/)にてプロジェクトを作成。選択したのは次の通り。
  - Project: Maven
  - Language: Kotlin
  - Spring Boot: 2.1.7
  - Project Metadata:
     - Group: com.pigutty.springboot
     - Artifact: Todolist
  - Dependencies:
     - Spring Web Starter 
     - HyperSQL Database
     - Thymeleaf
     - Spring Data JPA
     - Spring Boot DevTools
     - MySQL Driver
4. https://dev.mysql.com/downloads/connector/j/から(mysql-connector-java-8.0.17.tar.gz)をダウンロード。
