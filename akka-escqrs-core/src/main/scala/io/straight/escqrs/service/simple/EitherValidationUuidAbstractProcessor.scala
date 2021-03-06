package io.straight.escqrs.service.simple

import io.straight.escqrs.messages.{EventType, CommandType}
import io.straight.escqrs.model._
import io.straight.escqrs.service.{AbstractService, UuidRepository}

/**
 * This is so thin we probably don't need it.
 * The abstract type needs top change fropm Abstract to either Either or Scalaz Validation.
 *
 * @author rbuckland
 */
trait EitherValidationUuidAbstractProcessor[D <: DomainType[Uuid], E <: EventType, C <: CommandType] extends EitherValidationProcessor[D,E,C,Uuid] {
  val repository: UuidRepository[D]
  val idGenerator: UuidGenerator[D]
}



