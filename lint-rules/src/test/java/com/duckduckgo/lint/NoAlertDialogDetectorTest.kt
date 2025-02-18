/*
 * Copyright (c) 2022 DuckDuckGo
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

package com.duckduckgo.lint

import com.android.tools.lint.checks.infrastructure.TestFiles
import com.android.tools.lint.checks.infrastructure.TestLintTask
import com.duckduckgo.lint.NoFragmentDetector.Companion.NO_FRAGMENT_ISSUE
import com.duckduckgo.lint.ui.NoAlertDialogDetector
import com.duckduckgo.lint.ui.NoAlertDialogDetector.Companion
import org.junit.Test

class NoAlertDialogDetectorTest {

    @Test
    fun whenMaterialAlertDialogThenFailWithError() {
        TestLintTask.lint()
            .files(TestFiles.kt("""
              package com.duckduckgo.lint
    
                class Fragment

                    fun createDialog() {                    
                        MaterialAlertDialogBuilder.create()
                    }
            """).indented())
            .issues(NoAlertDialogDetector.NO_DESIGN_SYSTEM_DIALOG)
            .run()
            .expect("""
                src/com/duckduckgo/lint/Fragment.kt:5: Error: Fragment should not be directly extended [NoFragment]
                  class Duck : Fragment() {
                        ~~~~
                1 errors, 0 warnings
            """.trimMargin())
    }
}
