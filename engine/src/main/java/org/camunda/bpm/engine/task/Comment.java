/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine.task;

import java.util.Date;

import org.camunda.bpm.engine.TaskService;


/** User comments that form discussions around tasks.
 * 
 * @see {@link TaskService#getTaskComments(String)
 * @author Tom Baeyens
 */
public interface Comment {

  /** reference to the user that made the comment */ 
  String getUserId();

  /** time and date when the user made the comment */ 
  Date getTime();

  /** reference to the task on which this comment was made */ 
  String getTaskId();

  /** reference to the process instance on which this comment was made */ 
  String getProcessInstanceId();

  /** the full comment message the user had related to the task and/or process instance
   * @see TaskService#getTaskComments(String) */ 
  String getFullMessage();
}
