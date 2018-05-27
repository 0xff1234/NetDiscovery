package com.cv4j.netdiscovery.dsl

import com.cv4j.netdiscovery.core.Spider
import com.cv4j.netdiscovery.core.downloader.Downloader
import com.cv4j.netdiscovery.core.parser.Parser
import com.cv4j.netdiscovery.core.pipeline.Pipeline
import com.cv4j.netdiscovery.core.queue.Queue

/**
 * Created by tony on 2018/5/27.
 */
class SpiderWrapper {

    var name: String? = null

    var parser: Parser? = null

    var queue: Queue? = null

    var downloader: Downloader? = null

    var pipelines:Set<Pipeline>? = null

    var urls:Array<String>? = null

}

fun spider(init: SpiderWrapper.() -> Unit) {

    val wrap = SpiderWrapper()

    wrap.init()

    execute(wrap)
}

private fun execute(wrap:SpiderWrapper) {

    val spider = Spider.create(wrap?.queue)
            .name(wrap?.name)

    var urls = wrap?.urls?.toList()

    urls?.let {

        spider.url(urls)
    }

    spider.downloader(wrap?.downloader)
            .parser(wrap?.parser)
            .run()
}