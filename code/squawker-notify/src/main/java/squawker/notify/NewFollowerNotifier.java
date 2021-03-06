/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package squawker.notify;

import com.google.common.eventbus.Subscribe;
import squawker.notify.email.EmailMessage;
import squawker.notify.email.EmailSender;

// tag::notifier[]
public class NewFollowerNotifier {

  private EmailSender emailSender; // <1>

  @Subscribe // <2>
  public void onNewFollower(NewFollowerEvent event) throws Exception {
    EmailMessage message = new EmailMessage( // <3>
      "admin@squawker.io",
      "You have a new follower!",
      "new-follower",
      event.getNewFollower().getUsername()
    );
    emailSender.send(event.getUser(), message); // <4>
  }

  public void setEmailSender(EmailSender emailSender) {
    this.emailSender = emailSender;
  }
}
// end::notifier[]
