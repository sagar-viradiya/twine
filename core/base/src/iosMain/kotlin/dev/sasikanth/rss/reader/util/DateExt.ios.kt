/*
 * Copyright 2025 Sasikanth Miriyampalli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.sasikanth.rss.reader.util

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toNSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

actual fun Instant.readerDateTimestamp(): String {
  val formatter = NSDateFormatter()
  formatter.locale = NSLocale.currentLocale()
  formatter.dateFormat = "MMM dd, yyyy • hh:mm a"

  return formatter.stringFromDate(this.toNSDate())
}

actual fun LocalDateTime.homeAppBarTimestamp(): String {
  val formatter = NSDateFormatter()
  formatter.locale = NSLocale.currentLocale()
  formatter.dateFormat = "EEE, MMM dd"

  val date = this.toInstant(TimeZone.currentSystemDefault()).toNSDate()
  return formatter.stringFromDate(date)
}
