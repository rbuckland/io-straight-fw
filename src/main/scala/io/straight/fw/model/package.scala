/*
 * Copyright (C) 2013 soqqo ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.straight.fw

package object model {

  type DomainError          = List[String]
  object DomainError {
    def apply(msg: String): DomainError = List(msg)
  }

  // the validation type must implement isSuccess and isFailure
  type ValidationBase[T] = AnyRef[T] { def isSuccess: Boolean; def isFailure:Boolean }

  type IOValidation[V,T] = V[DomainError,T] {

  }

  type EitherValidation[T] = IOValidation[Either,T]

  type DomainType[I] = AnyRef{
    def id: I
    def version: Long
  }

  type UuidDomainType = DomainType[Uuid]{
    def id: Uuid
    def version: Long
  }


}
